--prompt: Write a query that will obtain the owner’s username, as well as the category name, questions, and answers of flashcard contained within the study set with and id of 4.

select app_user.username, category.name, flashcard.question, flashcard.answers, study_set.name, study_set.id from app_user