Create table developer
(
    id     BIGINT AUTO_INCREMENT,
    name   varchar(100),
    sex    varchar(100),
    salary int,
    PRIMARY KEY (id)

);
Create table company
(
    id   BIGINT AUTO_INCREMENT,
    name varchar(100),
    area varchar(100),
    primary key (id)
);

Create table customer
(
    id      BIGINT AUTO_INCREMENT,
    name    varchar(100),
    surname varchar(100),
    primary key (id)
);
Create table skill
(
    id         BIGINT AUTO_INCREMENT,
    technology varchar(100),
    skill      varchar(100),
    primary key (id)
);
Create table project
(
    id               BIGINT AUTO_INCREMENT,
    name             varchar(100),
    time_of_creation varchar(255),
    customer_id      BIGINT,
    company_id       BIGINT,
    foreign key (customer_id) REFERENCES customer (id) ON DELETE CASCADE,
    foreign key (company_id) REFERENCES company (id) ON DELETE CASCADE,
    primary key (id)
);

CREATE table developer_skill
(
    developer_id bigint not null,
    skill_id     bigint not null,

    FOREIGN KEY (developer_id) REFERENCES developer (id)ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skill (id)ON DELETE CASCADE
);



CREATE table developer_project
(
    developer_id BIGINT not null,
    project_id   BIGINT not null,
    PRIMARY KEY (developer_id, project_id),
    FOREIGN KEY (developer_id) REFERENCES developer (id)   ON DELETE CASCADE,
    FOREIGN KEY (project_id) REFERENCES project (id) ON DELETE CASCADE
);

ALTER TABLE skill
    ADD CONSTRAINT technologies_names
        Check (TECHNOLOGY IN ('Java', 'C++', 'C#', 'JS'));

ALTER TABLE skill
    ADD CONSTRAINT skills_levels
        Check (SKILL IN ('Senior', 'Middle', 'Junior'));


INSERT into company (NAME, AREA)
VALUES ('Samsung', 'Technology Development');