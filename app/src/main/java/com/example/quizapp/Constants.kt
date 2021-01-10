//1910047 Ziang Zhao
package com.example.quizapp

object Constants{                                                                                     //save all questions and answers data by using constants file

    const val User_name:String = "user_name"
    const val Total_questions:String = "total_question"
    const val Correct_answers:String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()                                                     //creat an array list in order to put all the questions inside

        val que1 = Question(1,
            "What is dog in Finnish?",
            "korra" ,
            "koiira",
            "kora",
            "koira",
            4
        )
        questionsList.add(que1)

        val que2 = Question(2,
            "What is cat in Finnish?",
            "kiisa" ,
            "kisä",
            "kissa",
            "kissä",
            3

        )
        questionsList.add(que2)

        val que3 = Question(3,
            "What is 1 in Finnish?",
            "yksi" ,
            "ykksi",
            "yyki",
            "yksii",
            1

        )
        questionsList.add(que3)

        val que4 = Question(4,
            "What is book in Finnish?",
            "kirjaa" ,
            "kiirja",
            "kirra",
            "kirja",
            4

        )
        questionsList.add(que4)

        val que5 = Question(5,
            "What is house in Finnish?",
            "talo" ,
            "tallo",
            "ttaalo",
            "taloo",
            1

        )
        questionsList.add(que5)

        val que6 = Question(6,
            "What is flowers in Finnish?",
            "kuka" ,
            "kukat",
            "kukkaa",
            "kukaa",
            2

        )
        questionsList.add(que6)

        val que7 = Question(7,
            "What is country in Finnish?",
            "koti" ,
            "maa",
            "maaa",
            "kott",
            2

        )
        questionsList.add(que7)

        val que8 = Question(8,
            "What is moon in Finnish?",
            "kku" ,
            "uku",
            "kuu",
            "ku",
            3

        )
        questionsList.add(que8)

        val que9 = Question(9,
            "What is game in Finnish?",
            "pely" ,
            "ppeli",
            "pela",
            "peli",
            4

        )
        questionsList.add(que9)


        val que10 = Question(10,
            "What is island in Finnish?",
            "sari" ,
            "saari",
            "sarri",
            "sarii",
            2

        )
        questionsList.add(que10)


        return questionsList
    }
}