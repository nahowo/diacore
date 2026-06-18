CREATE TABLE simulation_histories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    simulation_type VARCHAR(50) NOT NULL,
    exercise_type VARCHAR(50),
    duration_minutes INT,
    current_bg INT NOT NULL,
    predicted_drop_bg INT,
    recommended_carbs_g INT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_simulation_user_time ON simulation_histories (user_id, created_at);