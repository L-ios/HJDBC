CREATE TABLE if not exists container_stats
(
    __time         TIMESTAMP      NOT NULL,
    container_id   VARCHAR(64)   NOT NULL,
    container_name VARCHAR(255)  NOT NULL,
    cpu_percent    DECIMAL(5, 2) NOT NULL,
    memory_usage   BIGINT        NOT NULL,
    memory_limit   BIGINT        NOT NULL,
    memory_percent DECIMAL(5, 2) NOT NULL,
    network_rx     BIGINT        NOT NULL,
    network_tx     BIGINT        NOT NULL,
    block_read     BIGINT        NOT NULL,
    block_write    BIGINT        NOT NULL,
    pids           INT           NOT NULL,
    primary key (__time, container_id)
    );

CREATE INDEX idx_container ON container_stats (container_id);
CREATE INDEX idx_timestamp ON container_stats (__time);
