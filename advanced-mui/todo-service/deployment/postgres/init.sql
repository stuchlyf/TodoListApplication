-- Create Schema for TodoService
CREATE SCHEMA todo_service;
SET search_path TO todo_service;

-- Create TodoEntry Table
CREATE TABLE todo_entry (
    id int not null,
    title varchar(50) not null null,
    description text,
    completed boolean not null
)