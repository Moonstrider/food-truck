//package com.mountains.micro.common.config;
//
//import com.mountains.micro.common.util.SnowflakeIdWorker;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.math.BigDecimal;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Slf4j
//@Configuration
//public class MachineIdConfig {
//
//    @Value("${application.snowflake.data-center}")
//    private Long dataCenterId;
//
//    @Value("${application.snowflake.biz-type}")
//    private String bizType;
//
//    private int machineId;
//
//    /**
//     * get IP address
//     *
//     * @return
//     * @throws UnknownHostException
//     */
//    private String getIPAddress() throws UnknownHostException {
//        InetAddress address = InetAddress.getLocalHost();
//        return address.getHostAddress();
//    }
//
//    /**
//     * hash machine IP to initialize a machine ID
//     *
//     * @throws UnknownHostException
//     */
//    @Bean
//    public SnowflakeIdWorker initMachineId() throws UnknownHostException {
//        String localIp = getIPAddress();
//
//        int ipint = 0;
//        try {
//            long ipLong = Long.parseLong(localIp.replace(".", ""));
//            ipint = new BigDecimal(Long.hashCode(ipLong)).abs().intValue();
//        } catch (NumberFormatException e) {
//            log.warn("Can't convert ip [{}] to number", localIp);
//        }
//        machineId = ipint % ((int) SnowflakeIdWorker.MAX_WORKER_ID + 1);
//
//        log.info("initialize machine_id :{}", machineId);
//
//        return new SnowflakeIdWorker(machineId, dataCenterId);
//    }
//
//    /**
//     * delete register record when destroy
//     */
////	@PreDestroy
////	public void destroyMachineId() {
////		redisTemplate.delete(generateRedisKey(machineId));
////	}
//
//    /**
//     * main method to get a machine ID
//     *
//     * @return
//     */
//    public Integer createMachineId() {
//        // register successfully
////		if (registerMachine(machineId, localIp)) {
////			// start a thread to update timeout
////			updateExpTimeThread();
////		} else {
////			// if can't register
////			if (checkIfCanRegister()) {
////				createMachineId();
////			} else {
////				throw new SystemException("All machine IDs are occupied and please clean redis.");
////			}
////
////		}
////		log.info("createMachineId->ip:{},machineId:{}, time:{}", localIp, machineId, LocalDateTime.now());
//        return machineId;
//    }
//
////	/**
////	 * @return
////	 */
////	private Boolean checkIfCanRegister() {
////		Boolean flag = true;
////		// check if 0~127 has been occupied
////		for (int i = 0; i <= (int) SnowflakeIdWorker.MAX_WORKER_ID; i++) {
////			flag = redisTemplate.hasKey(generateRedisKey(i));
////			// can register
////			if (!flag) {
////				machineId = i;
////				break;
////			}
////		}
////		return !flag;
////	}
////
////	/**
////	 *
////	 */
////	private void updateExpTimeThread() {
////		// start a thread to execute a job
////		// update expire time every 23 hours
////		new Timer(localIp).schedule(new TimerTask() {
////			@Override
////			public void run() {
////				log.info("Update expire time ip:{}, machineId:{}, time:{}", localIp, machineId, LocalDateTime.now());
////				redisTemplate.expire(generateRedisKey(machineId), 60L * 60L * 24L * 1000L, TimeUnit.MILLISECONDS);
////			}
////		}, 10L * 1000L, 60L * 60L * 23L * 1000L);
////	}
////
////	/**
////	 * 1.register 2.set expire time
////	 *
////	 * @param machineId the value is between 0~127
////	 * @return
////	 */
////	private Boolean registerMachine(Integer machineId, String localIp) {
////		String redisKey = generateRedisKey(machineId);
////		if (redisTemplate.hasKey(redisKey)) {
////			return false;
////		} else {
////			redisTemplate.opsForValue().set(redisKey, localIp, 60L * 60L * 24L * 1000L, TimeUnit.MILLISECONDS);
////			return true;
////		}
////	}
////
////	private String generateRedisKey(Integer machineId) {
////		return String.format(CommonRedisKey.MACHINE_ID, bizType, dataCenterId, machineId);
////	}
//
//}
