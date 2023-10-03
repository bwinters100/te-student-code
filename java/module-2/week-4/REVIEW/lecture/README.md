# DAO QuizMaker
This version of QuizMaker includes four DAO implementations: one for reading from text files, one for reading from memory and two for reading from a database. The alternate JDBC Dao uses implementations of the `RowMapper` interface instead of iterating over the returned `SqlRowSet`.  Which one is used depends on which environment variables are set.

* If the environment variable `IN_MEM=true` is set then the Memory DAO is used.
* If the environment variable `DB_URL` is set then one of the JDBC DAOs is used.  
  * In this case, if the environment variable `USE_X=true` is set then the alternate JDBC DAO is used.
* In all other cases, the File DAO is used.

For the JDBC DAOs, here are typical values for the environment variables:
* DB_URL = `jdbc:postgresql://localhost:5432/quiz_db`
* DB_USER = `postgres`
* DB_PASSWORD = `postgres1`

SQL for creating the database is in the `database` folder. It includes two questions for one quiz (`test_quiz`). The database design allows for questions to be associated with multiple quizzes.

After starting the program, enter a quiz name (`test_quiz` or `another_quiz`, for example) and the corresponding quiz will be loaded from a text file with that name (plus the `.txt` extension) or from the database.
