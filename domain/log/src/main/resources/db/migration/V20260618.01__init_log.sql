CREATE TABLE glucose_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    timestamp DATETIME NOT NULL,
    value INT NOT NULL,
    trend_arrow VARCHAR(20),
    source VARCHAR(20) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_glucose_logs_user_time ON glucose_logs (user_id, timestamp);

CREATE TABLE insulin_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    timestamp DATETIME NOT NULL,
    dose FLOAT NOT NULL,
    insulin_type VARCHAR(20) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_insulin_logs_user_time ON insulin_logs (user_id, timestamp);

CREATE TABLE meal_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    timestamp DATETIME NOT NULL,
    carbohydrate_g INT NOT NULL,
    meal_type VARCHAR(20) NOT NULL,
    food_desc VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_meal_logs_user_time ON meal_logs (user_id, timestamp);