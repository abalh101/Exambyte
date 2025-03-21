create table exam_test (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     startzeitpunkt date,
    endzeitpunkt date ,
    name varchar(20),
  maximalpunktzahl   integer ,
 ergebnisVeröffentlichungszeitpunkt    date

);
