-- public.biz_food_truck definition

-- Drop table

-- DROP TABLE public.biz_food_truck;

CREATE TABLE biz_food_truck
(
    id   int8         NOT NULL,
    applicant     varchar(255) NOT NULL,
    facility_type varchar(50)  NULL,
    create_time   timestamp    NOT NULL DEFAULT now(),
    create_by     varchar(100) NOT NULL,
    update_time   timestamp    NOT NULL,
    update_by     varchar(100) NOT NULL,
    is_active     int2         NOT NULL DEFAULT 1,
    "version"     int4         NOT NULL DEFAULT 0,
    CONSTRAINT biz_food_truck_pkey PRIMARY KEY (id)
);