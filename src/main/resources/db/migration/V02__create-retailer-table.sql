CREATE TABLE IF NOT EXISTS "retailers" (
    "id" UUID NOT NULL,
    "owner_id" UUID NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "description" TEXT NOT NULL,
    "phone" VARCHAR(255) NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    "image_url" VARCHAR(255),
    "created_at" TIMESTAMPTZ NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY("id")
    );

CREATE UNIQUE INDEX "retailer_index"
    ON "retailers" ("phone");

ALTER TABLE "retailers"
    ADD FOREIGN KEY("owner_id") REFERENCES "users"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION;