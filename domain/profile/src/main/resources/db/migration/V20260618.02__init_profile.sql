CREATE TABLE user_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    nickname VARCHAR(50) NOT NULL,
    target_bg INT NOT NULL DEFAULT 100,
    timezone VARCHAR(50) NOT NULL DEFAULT 'Asia/Seoul',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE therapy_cr (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_time TINYINT NOT NULL CHECK (start_time BETWEEN 0 AND 23),
    carb_ratio FLOAT NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    CONSTRAINT uk_user_cr_time UNIQUE (user_id, start_time)
);

CREATE TABLE therapy_cr_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_time TINYINT NOT NULL,
    original_value FLOAT NOT NULL,
    new_value FLOAT NOT NULL,
    reason_text VARCHAR(255),
    created_at DATETIME(6) NOT NULL
);

CREATE TABLE therapy_isf (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_time TINYINT NOT NULL CHECK (start_time BETWEEN 0 AND 23),
    insulin_sensitivity FLOAT NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    CONSTRAINT uk_user_isf_time UNIQUE (user_id, start_time)
);

CREATE TABLE therapy_isf_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_time TINYINT NOT NULL,
    original_value FLOAT NOT NULL,
    new_value FLOAT NOT NULL,
    reason_text VARCHAR(255),
    created_at DATETIME(6) NOT NULL
);

CREATE TABLE therapy_parameters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_hour INT NOT NULL,
    end_hour INT NOT NULL,
    carb_ratio DECIMAL(5,2) NOT NULL,
    insulin_sensitivity DECIMAL(5,2) NOT NULL,
    basal_rate DECIMAL(5,2),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT chk_start_hour CHECK (start_hour >= 0 AND start_hour <= 23)
);

CREATE INDEX idx_therapy_user_hour ON therapy_parameters (user_id, start_hour);

CREATE TABLE recommendation_histories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    parameter_type VARCHAR(20) NOT NULL,
    target_hour INT NOT NULL,
    original_value DECIMAL(5,2) NOT NULL,
    recommended_value DECIMAL(5,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    reason_text VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_recommendation_user ON recommendation_histories (user_id);