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
    profile_snapshot JSON NOT NULL,
    change_source VARCHAR(30) NOT NULL,
    reason_text VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_cr_history_user_id (user_id)
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
    profile_snapshot JSON NOT NULL,
    change_source VARCHAR(30) NOT NULL,
    reason_text VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_isf_history_user_id (user_id)
);

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