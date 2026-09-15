CREATE TABLE IF NOT EXISTS "stations" (
    "id" UUID NOT NULL,
    "user_id" UUID NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "description" TEXT NOT NULL,
    "phone" VARCHAR(255) NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY("id")
    );

CREATE UNIQUE INDEX "Station_index"
    ON "stations" ("phone");

ALTER TABLE "stations"
    ADD FOREIGN KEY("user_id") REFERENCES "users"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION;