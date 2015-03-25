/**Creating trigger function UPDATE_TIMESTAMP()
 * which is a common method for all table
 * After executing this function create trigger in respective tables 
 */

CREATE FUNCTION UPDATE_TIMESTAMP() RETURNS trigger AS $UPDATE_TIMESTAMP$
    BEGIN
        NEW.modified_dttm := current_timestamp;
        RETURN NEW;
    END;
$UPDATE_TIMESTAMP$ LANGUAGE plpgsql;