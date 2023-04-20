package com.mountains.micro.common.util;


/**
 * Twitter_Snowflake<br>
 * SnowFlake's structure is as below (separated by dash -):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 -
 * 000000000000 <br>
 * sign - 1 bit, always 0 time - 41 bits (millisecond precision w/ a custom
 * epoch gives us 69 years) configured machine id - 10 bits - gives us up to
 * 1024 machines sequence number - 12 bits - rolls over every 4096 per machine
 * (with protection to avoid rollover in the same ms)
 */
public class SnowflakeIdWorker {

    private static SnowflakeIdWorker idWorker;

    // 部署多台服务,这里可以交给 Spring 管理,注入workerId
    static {
        idWorker = new SnowflakeIdWorker(1L, 1L);
    }

    public static Long getId() {
        return idWorker.nextId();
    }


    // ==============================Fields===========================================
    /**
     * start timestamp (2015-01-01)
     */
    private final long twepoch = 1420041600000L;

    /**
     * the bit number of worker ID
     */
    private static final long WORKER_ID_BITS = 7L;

    /**
     * the bit number of data center ID
     */
    private final long datacenterIdBits = 3L;

    /**
     * supported max worker ID, the result is 127 (this shift algorithm can compute
     * the max number of Decimal system based on n bit of Binary system quickly)
     */
    public static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);

    /**
     * supported max data center ID, the result is 7
     */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**
     * the bit number of sequence
     */
    private final long sequenceBits = 12L;

    /**
     * worker ID after doing left shift 12 bit
     */
    private final long workerIdShift = sequenceBits;

    /**
     * data center ID after doing left shift 19 bit(12+7)
     */
    private final long datacenterIdShift = sequenceBits + WORKER_ID_BITS;

    /**
     * timestamp after doing left shift 22 bit(12+7+3)
     */
    private final long timestampLeftShift = sequenceBits + WORKER_ID_BITS + datacenterIdBits;

    /**
     * mask code of sequence, the result is 4095 (0b111111111111=0xfff=4095)
     */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * worker ID(0~31)
     */
    private long workerId;

    /**
     * data center ID(0~31)
     */
    private long datacenterId;

    /**
     * sequence in millisecond(0~4095)
     */
    private long sequence = 0L;

    /**
     * generated timestamp of last ID
     */
    private long lastTimestamp = -1L;

    // ==============================Constructors=====================================

    /**
     * Constructor method
     *
     * @param workerId     worker ID (0~31)
     * @param datacenterId data center ID (0~31)
     */
    public SnowflakeIdWorker(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // ==============================Methods==========================================

    /**
     * get next ID (thread safe)
     *
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        // if current timestamp is less than last timestamp it means system clock has
        // been rolled back and throw exception
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // if it is same, increase sequence in millisecond
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // if sequence overflow in millisecond
            if (sequence == 0) {
                // block until next millisecond, get new timestamp
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // if timestamp changed, reset sequence in millisecond
        else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // combine a 64 bits ID by shift bit and or operator
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterIdShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * block one millisecond until getting new timestamp
     *
     * @param lastTimestamp generated timestamp of last ID
     * @return current timestamp
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * return current time based on millisecond
     *
     * @return current time millisecond
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
