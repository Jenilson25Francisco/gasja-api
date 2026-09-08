CREATE TABLE IF NOT EXISTS "Users" (
    "id" UUID NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY("id")
    );

CREATE UNIQUE INDEX "Users_index_0"
    ON "Users" ("email");