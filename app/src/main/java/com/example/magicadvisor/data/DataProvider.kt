package com.example.magicadvisor.data

import com.example.magicadvisor.ui.AchievementType

object DataProvider {

    private val quotes = listOf(
        Quote(
            1,
            "It takes courage to grow up and become who you really are.",
            "E.E. Cummings"
        ),
        Quote(
            2,
            "Your self-worth is determined by you. You don't have to depend on someone telling you who you are.",
            "Beyoncé"
        ),
        Quote(
            3,
            "Nothing is impossible. The word itself says 'I'm possible!'",
            "Audrey Hepburn"
        ),
        Quote(
            4,
            "Keep your face always toward the sunshine, and shadows will fall behind you.",
            "Walt Whitman"
        ),
        Quote(
            5,
            "You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose. You're on your own. And you know what you know. And you are the guy who'll decide where to go.",
            "Dr. Seuss"
        ),
        Quote(
            6,
            "Attitude is a little thing that makes a big difference.",
            "Winston Churchill"
        ),
        Quote(
            7,
            "To bring about change, you must not be afraid to take the first step. We will fail when we fail to try.",
            "Rosa Parks"
        ),
        Quote(
            8,
            "All our dreams can come true, if we have the courage to pursue them.",
            "Walt Disney"
        ),
        Quote(
            9,
            "Don't sit down and wait for the opportunities to come. Get up and make them.",
            "Madam C.J. Walker"
        ),
        Quote(
            10,
            "Champions keep playing until they get it right.",
            "Billie Jean King"
        ),
        Quote(
            11,
            "I am lucky that whatever fear I have inside me, my desire to win is always stronger.",
            "Serena Williams"
        ),
        Quote(
            12,
            "You are never too old to set another goal or to dream a new dream.",
            "C.S. Lewis"
        ),
        Quote(
            13,
            "It is during our darkest moments that we must focus to see the light.",
            "Aristotle"
        ),
        Quote(
            14,
            "Believe you can and you're halfway there.",
            "Theodore Roosevelt"
        ),
        Quote(
            15,
            "Life shrinks or expands in proportion to one’s courage.",
            "Anaïs Nin"
        ),
        Quote(
            16,
            "Just don't give up trying to do what you really want to do. Where there is love and inspiration, I don't think you can go wrong.",
            "Ella Fitzgerald"
        ),
        Quote(
            17,
            "Try to be a rainbow in someone's cloud.",
            "Maya Angelou"
        ),
        Quote(
            18,
            "If you don't like the road you're walking, start paving another one.",
            "Dolly Parton"
        ),
        Quote(
            19,
            "Real change, enduring change, happens one step at a time.",
            "Ruth Bader Ginsburg"
        ),
        Quote(
            20,
            "All dreams are within reach. All you have to do is keep moving towards them.",
            "Viola Davis"
        ),
        Quote(
            21,
            "It is never too late to be what you might have been.",
            "George Eliot"
        ),
        Quote(
            22,
            "When you put love out in the world it travels, and it can touch people and reach people in ways that we never even expected.",
            "Laverne Cox"
        ),
        Quote(
            23,
            "Give light and people will find the way.",
            "Ella Baker"
        ),
        Quote(
            24,
            "It always seems impossible until it's done.",
            "Nelson Mandela"
        ),
        Quote(
            25,
            "Don’t count the days, make the days count.",
            "Muhammad Ali"
        ),
        Quote(
            26,
            "If you risk nothing, then you risk everything.",
            "Geena Davis"
        ),
        Quote(
            27,
            "Definitions belong to the definers, not the defined.",
            "Toni Morrison"
        ),
        Quote(
            28,
            "When you have a dream, you've got to grab it and never let go.",
            "Carol Burnett"
        ),
        Quote(
            29,
            "Never allow a person to tell you no who doesn’t have the power to say yes.",
            "Eleanor Roosevelt"
        ),
        Quote(
            30,
            "When it comes to luck, you make your own.",
            "Bruce Springsteen"
        ),
        Quote(
            31,
            "If you're having fun, that's when the best memories are built.",
            "Simone Biles"
        ),
        Quote(
            32,
            "Failure is the condiment that gives success its flavor.",
            "Truman Capote"
        ),
        Quote(
            33,
            "Hard things will happen to us. We will recover. We will learn from it. We will grow more resilient because of it.",
            "Taylor Swift"
        ),
        Quote(
            34,
            "Your story is what you have, what you will always have. It is something to own.",
            "Michelle Obama"
        ),
        Quote(
            35,
            "To live is the rarest thing in the world. Most people just exist.",
            "Oscar Wilde"
        ),
        Quote(
            36,
            "You define beauty yourself, society doesn’t define your beauty.",
            "Lady Gaga"
        ),
        Quote(
            37,
            "Optimism is a happiness magnet. If you stay positive, good things and good people will be drawn to you.",
            "Mary Lou Retton"
        ),
        Quote(
            38,
            "You just gotta keep going and fighting for everything, and one day you’ll get to where you want.",
            "Naomi Osaka"
        ),
        Quote(
            39,
            "If you prioritize yourself, you are going to save yourself.",
            "Gabrielle Union"
        ),
        Quote(
            40,
            "No matter how far away from yourself you may have strayed, there is always a path back. You already know who you are and how to fulfill your destiny.",
            "Oprah Winfrey"
        ),
        Quote(
            41,
            "A problem is a chance for you to do your best.",
            "Duke Ellington"
        ),
        Quote(
            42,
            "You can’t turn back the clock. But you can wind it up again.",
            "Bonnie Prudden"
        ),
        Quote(
            43,
            "When you can’t find someone to follow, you have to find a way to lead by example.",
            "Roxane Gay"
        ),
        Quote(
            44,
            "There is no better compass than compassion.",
            "Amanda Gorman"
        ),
        Quote(
            45,
            "Stand before the people you fear and speak your mind – even if your voice shakes.",
            "Maggie Kuhn"
        ),
        Quote(
            46,
            "It’s a toxic desire to try to be perfect. I realized later in life that the challenge is not to be perfect. It’s to be whole.",
            "Jane Fonda"
        ),
        Quote(
            47,
            "Vitality shows not only in the ability to persist but in the ability to start over.",
            "F. Scott Fitzgerald"
        ),
        Quote(
            48,
            "The most common way people give up their power is by thinking they don’t have any.",
            "Alice Walker"
        ),
        Quote(
            49,
            "Love yourself first and everything else falls into line.",
            "Lucille Ball"
        ),
        Quote(
            50,
            "In three words I can sum up everything I've learned about life: It goes on.",
            "Robert Frost"
        ),

    )

    private val answers = listOf(
        Answer(
            1,
            "Yes",
            AnswerType.POSITIVE
        ),
        Answer(
            2,
            "No",
            AnswerType.NEGATIVE
        ),
        Answer(
            3,
            "Maybe",
            AnswerType.NEUTRAL
        ),
        Answer(
            4,
            "I don't know",
            AnswerType.NEUTRAL
        ),
        Answer(
            5,
            "Ask later",
            AnswerType.NEUTRAL
        ),
        Answer(
            6,
            "Ask yourself",
            AnswerType.NEUTRAL
        ),
        Answer(
            7,
            "Absolutely",
            AnswerType.POSITIVE
        ),
        Answer(
            8,
            "ABSOLUTELY NOT!!",
            AnswerType.NEGATIVE
        ),
        Answer(
            9,
            "Definitely not",
            AnswerType.NEGATIVE
        ),
        Answer(
            10,
            "Of course",
            AnswerType.POSITIVE
        ),
        Answer(
            11,
            "Never",
            AnswerType.NEGATIVE
        ),
        Answer(
            12,
            "It's unclear",
            AnswerType.NEUTRAL
        ),
        Answer(
            13,
            "Can’t say right now",
            AnswerType.NEUTRAL
        ),
        Answer(
            14,
            "Try again later",
            AnswerType.NEUTRAL
        ),
        Answer(
            15,
            "Signs point to yes",
            AnswerType.POSITIVE
        ),
        Answer(
            16,
            "It’s complicated",
            AnswerType.NEUTRAL
        ),
        Answer(
            17,
            "Ask again",
            AnswerType.NEUTRAL
        ),
        Answer(
            18,
            "Go for it!",
            AnswerType.POSITIVE
        ),
        Answer(
            19,
            "Not today",
            AnswerType.NEGATIVE
        ),
        Answer(
            20,
            "It’s not the right time",
            AnswerType.NEGATIVE
        ),
        Answer(
            21,
            "Consider other options",
            AnswerType.NEGATIVE
        ),
        Answer(
            22,
            "Obviously",
            AnswerType.POSITIVE
        ),
        Answer(
            23,
            "Really? You need to ask?",
            AnswerType.NEUTRAL
        ),
        Answer(
            24,
            "In your dreams",
            AnswerType.NEGATIVE
        ),
        Answer(
            25,
            "Why not? Go crazy!",
            AnswerType.POSITIVE
        ),
        Answer(
            26,
            "Do I look like I know?",
            AnswerType.NEUTRAL
        ),
        Answer(
            27,
            "Sure, if you’re into bad ideas",
            AnswerType.NEGATIVE
        ),
        Answer(
            28,
            "Only if the stars align",
            AnswerType.NEGATIVE
        ),
        Answer(
            29,
            "Flip a coin",
            AnswerType.NEUTRAL
        ),
        Answer(
            30,
            "Yes, but only on Tuesdays",
            AnswerType.POSITIVE
        ),
        Answer(
            32,
            "Better ask your cat",
            AnswerType.NEUTRAL
        ),
        Answer(
            33,
            "Better call your mom...",
            AnswerType.NEGATIVE
        ),
        Answer(
            34,
            "Does it matter?",
            AnswerType.NEUTRAL
        ),
        Answer(
            35,
            "Consult a professional",
            AnswerType.NEUTRAL
        ),
        Answer(
            36,
            "The answer lies within you",
            AnswerType.NEUTRAL
        ),
        Answer(
            37,
            "What do you think?",
            AnswerType.NEUTRAL
        ),
        Answer(
            38,
            "Only time will tell",
            AnswerType.NEUTRAL
        ),
        Answer(
            39,
            "Some questions are better left unanswered",
            AnswerType.NEUTRAL
        ),
        Answer(
            40,
            "This decision could change your life",
            AnswerType.NEUTRAL
        ),
        Answer(
            41,
            "Proceed with caution",
            AnswerType.POSITIVE
        ),
        Answer(
            42,
            "Don’t rush into it",
            AnswerType.NEGATIVE
        ),
        Answer(
            43,
            "I can not read your mind",
            AnswerType.NO_QUESTION
        ),
        Answer(
            44,
            "Say something",
            AnswerType.NO_QUESTION
        ),
        Answer(
            45,
            "The silence is deafening...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            46,
            "Sometimes silence is the best answer...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            47,
            "The void also speaks, if you listen...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            48,
            "Perhaps your silence holds the key...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            49,
            "Only the brave dare to ask...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            50,
            "It's so quiet here",
            AnswerType.NO_QUESTION
        ),
        Answer(
            51,
            "I can only guess what you want to ask...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            52,
            "I can not answer until you ask",
            AnswerType.NO_QUESTION
        ),
        Answer(
            53,
            "...",
            AnswerType.NO_QUESTION
        ),
        Answer(
            54,
            "Hello?",
            AnswerType.NO_QUESTION
        ),
        Answer(
            55,
            "I have answered this already",
            AnswerType.REPEAT
        ),
        Answer(
            56,
            "Sometimes, asking the same question reveals more than the answer",
            AnswerType.REPEAT
        ),
        Answer(
            57,
            "Perhaps it’s not the question that needs to change, but your perspective",
            AnswerType.REPEAT
        ),
        Answer(
            58,
            "The same question might hold a different meaning now",
            AnswerType.REPEAT
        ),
        Answer(
            59,
            "Repetition is the path to understanding",
            AnswerType.REPEAT
        ),
        Answer(
            60,
            "The question hasn’t changed, but have you?",
            AnswerType.REPEAT
        ),
        Answer(
            61,
            "Repeating it won’t make it more important",
            AnswerType.REPEAT
        ),
        Answer(
            62,
            "Maybe it’s time to stop asking and start acting",
            AnswerType.REPEAT
        )
    )

    private val advices = listOf(
        Advice(
            1,
            "Take time to rest – Your brain needs recovery to stay sharp"
        ),
        Advice(
            2,
            "Drink more water – Staying hydrated improves focus and energy levels"
        ),
        Advice(
            3,
            "Embrace failure as a learning opportunity"
        ),
        Advice(
            4,
            "Spend more time in nature – It has been shown to reduce stress and improve mood"
        ),
        Advice(
            5,
            "Set small, achievable goals to build momentum"
        ),
        Advice(
            6,
            "Practice mindfulness to reduce anxiety and improve overall well-being"
        ),
        Advice(
            7,
            "Get enough sleep – A lack of sleep impairs memory and cognitive function"
        ),
        Advice(
            8,
            "Be kind to others – Helping others boosts your happiness and self-worth"
        ),
        Advice(
            9,
            "Challenge your brain with puzzles or learning new things regularly"
        ),
        Advice(
            10,
            "Be patient with yourself – Change takes time and progress is gradual"
        ),
        Advice(
            11,
            "Exercise regularly – Physical activity is proven to boost mood and brain health"
        ),
        Advice(
            12,
            "Keep a gratitude journal – Writing down things you're grateful for improves happiness"
        ),
        Advice(
            13,
            "Learn to say “no” – Setting boundaries helps prevent burnout"
        ),
        Advice(
            14,
            "Read more books – They stimulate your mind and improve empathy"
        ),
        Advice(
            15,
            "Avoid multitasking – It can reduce your productivity and lead to more mistakes"
        ),
        Advice(
            16,
            "Spend time with people who make you feel positive and supported"
        ),
        Advice(
            17,
            "Laugh often – It reduces stress and releases endorphins, making you feel happier"
        ),
        Advice(
            18,
            "Take deep breaths – It helps lower stress and enhances your focus"
        ),
        Advice(
            19,
            "Don’t compare yourself to others – Focus on your own progress and growth"
        ),
        Advice(
            20,
            "Practice self-compassion – Be gentle with yourself when things don’t go as planned"
        ),
        Advice(
            21,
            "Track your progress – Recognizing your achievements boosts motivation"
        ),
        Advice(
            22,
            "Listen to music – It can enhance creativity, focus, and mood"
        ),
        Advice(
            23,
            "Do something creative every day – It sparks new ideas and helps reduce stress"
        ),
        Advice(
            24,
            "Limit screen time – Too much exposure to screens can lead to eye strain and fatigue"
        ),
        Advice(
            25,
            "Eat a balanced diet – What you eat affects your energy levels and mental clarity"
        ),
        Advice(
            26,
            "Spend time on hobbies you love – They reduce stress and foster creativity"
        ),
        Advice(
            27,
            "Volunteer or help others – Acts of kindness improve your mental health"
        ),
        Advice(
            28,
            "Cultivate optimism – Positive thinking can help you overcome obstacles"
        ),
        Advice(
            29,
            "Don’t be afraid to ask for help – Seeking support strengthens your emotional health"
        ),
        Advice(
            30,
            "Stay curious – The more you learn, the more you grow"
        )
    )

    fun getNormalAnswer(): Answer {
        val listOfNormalAnswers = answers.filter { it.type != AnswerType.NO_QUESTION && it.type != AnswerType.REPEAT }
        return listOfNormalAnswers.random()
    }

    fun getRepeatAnswer(): Answer {
        val listOfRepeatAnswers = answers.filter { it.type == AnswerType.REPEAT }
        return listOfRepeatAnswers.random()
    }

    fun getNoQuestionAnswer(): Answer {
        val listOfNoQuestionAnswers = answers.filter { it.type == AnswerType.NO_QUESTION }
        return listOfNoQuestionAnswers.random()
    }

    fun getQuote(): Quote {
        return quotes.random()
    }

    fun getAdvice(): Advice {
        return advices.random()
    }

    val answersSize = answers.size
    val quotesSize = quotes.size
    val advicesSize = advices.size

    enum class AnswerType {
        POSITIVE,
        NEGATIVE,
        NEUTRAL,
        NO_QUESTION,
        REPEAT
    }
    data class Answer(
        val id: Int,
        val text: String,
        val type: AnswerType
    )
    val defaultAnswer = Answer(
        id = 0,
        text = "",
        type = AnswerType.NEUTRAL
    )

    data class Quote(
        val id: Int,
        val quote: String,
        val author: String? = null
    )

    val defaultQuote = Quote(
        id = 0,
        quote = ""
    )

    data class Advice(
        val id: Int,
        val text: String
    )

    val defaultAdvice = Advice(
        id = 0,
        text = ""
    )

    fun getAchievement(id: Int, achievementType: AchievementType): String {
        return when (achievementType) {
            AchievementType.ANSWER -> {
                answers.find { it.id == id }?.text ?: ""
            }

            AchievementType.QUOTE -> {
                "${quotes.find { it.id == id }?.quote ?: ""} — ${quotes.find { it.id == id }?.author ?: ""}"
            }

            AchievementType.ADVICE -> {
                advices.find { it.id == id }?.text ?: ""
            }
        }
    }
}
