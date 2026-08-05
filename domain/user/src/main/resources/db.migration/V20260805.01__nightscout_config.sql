CREATE TABLE nightscout_configs (
    user_id         BIGINT PRIMARY KEY REFERENCES users(id),
    encrypted_url   TEXT NOT NULL,
    encrypted_secret TEXT NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP NOT NULL DEFAULT now()
);