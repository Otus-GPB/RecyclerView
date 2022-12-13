package otus.gpb.recyclerview

class ChatItem {

    private val someList = mutableListOf(
        Chat(
            0L,
            "https://s3-alpha-sig.figma.com/img/5033/63a4/020a4a49174ccc700c2568ef89ec68f6?Expires=1671408000&Signature=JULwrlXTddGzt0Aw4nBMFac1DO08jAqMycUWbeP4gKkAla17h4xolOoRlGMEXXhZsy1bZm7nHaEuWzp2-j-n8vT4viYzNOzrCGlUQc1MyTE~Non30kuKLVyHkmmmvYbqLQc~Rg1JgWsNxx~qiTbDDcFqtDifVplnxny-z0eez7T3np7kq16o5ZmCqeyVYMe0w4mPWzLwsF0x5AOKsPIua756wL5byu5XAnDYLEW~oFejvK-md87FwZLoBWxHYx~xMIYtLIZ7sWSbPbFWcdVmp3GczoM3WDlME9cKRG5fnAxel0JSsmlhW0T7tTq~EFSPgCwYRN9VINDEfLsq3BbKTg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Pizza",
            "Yes, they are necessary",
            "11:38 AM",
            isVerified = false,
            isMute = true,
            "jija",
            isDone = false
        ),
        Chat(
            1L,
            "https://s3-alpha-sig.figma.com/img/f867/fc08/2aeb631f69f388021ce66dd38e5ecf16?Expires=1671408000&Signature=ahF3seYn8BEbyXdPD1lL5E7tp7vaRWMv85lqOTzN6Lea-DYg-PW5G5kHK5Lb5gX7CfN9-dr1s9rUpTOKbNbMGFUBigXV7FkH0lNBfxcIVCnmIm~33BF~4wkvC~5KXL0JSQt9XkTN68Ke2-DJjUikIZEdBGCVaFuBqrgsTIYOSId~uheZL6Vap7gs0ToW4wlH0nOH3VTmBykPyKDS2AFs~nrvHpcNj3WMmzAikazMLfT0Meo9J3dhIl3VgrpHvnQ5ZSDnMgKbgUELawGr7uzPGk4UoSMgwrFQG007~VXd0R7Ovr3tScuwJK2AnbI9PUnMRKDl-~tz2LvUJKt9jOOzgw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Elon",
            "I love /r/Reddit!",
            "12:44 AM",
            isVerified = true,
            isMute = true,
            null,
            isDone = false
        ),
        Chat(
            2L,
            "https://s3-alpha-sig.figma.com/img/df48/8ca2/ae5ecb7b733c77cb53424927482baab2?Expires=1671408000&Signature=Ffu1jhMnJygK7rnsvaRrco5Wai3zYfdtQfh-yztMmFcvxlrGL0N8BKpraXgXsdHWo7-4w3AS5YnoTkw9Zw17K7HH9U9wnuGjaNfqWnOwCZ0ae9n6XG50k9~CF1aO13SGBdweTf35Xwb5yH0dP6Z9BMt2XqAv9720je7h-flZflxSCapZZUhVvOER75JJ39bqasB9aqOEK1kKcc0tQ4McOPpJoFrRdOamnIIvJdYp24KhLOs3C6CncjOwWZQiMj3u7wa2phjEN6CyZCNXLPopUvrDCwTqyI9HL0J3jk3Qbgskai0kzfVVOvAOnd-0eMzzrgHGnIb2D61g2ZvAVY0DOg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Pasha",
            "How are u?",
            "Fri",
            isVerified = true,
            isMute = true,
            null,
            isDone = false
        ),
        Chat(
            3L,
            "https://s3-alpha-sig.figma.com/img/c00a/8f10/8169e5d8911051999a4259ec0d458ce6?Expires=1671408000&Signature=LybZzmymB1U~lo4k6MeUpGGTiRumuwf8Ij2DoHbsGZuz0UipHhvpcOrdc5stDLspNv7k60fGrPrnWsuZrACjj6mL3DrRXJSYp37xFi8vWCc~NKzqTnI4TfIOwntWEL9RYOM3FtrMnWeqCMJBriwneq1Msljws9F3N8tHGQ6fWGkhX2scLIeaoX8igc380F1qbj0CChVIGJ4TjvLRKwUr6~SdpHEr-bxQm6VUkaW-b-VdLJYLlt6fgdCP1Seu42HHPvLo00yhMIw3bAC7V3ykme-aoPYZ-DQ9V7UcByPiQD6gUKggyiqaNcFWue03op7iGkG18RHQeq1EEo-W9r1NTQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Telegram Support",
            "Yes it happened.",
            "Thu",
            isVerified = true,
            isMute = false,
            "Support",
            isDone = false
        ),
        Chat(
            4L,
            "https://s3-alpha-sig.figma.com/img/db01/68d2/f4f8f5fb995ed12531163881bc075d74?Expires=1671408000&Signature=AaA-GZIxfyjNLdPFufQTLanWxoNyPd5oXqj1WAkEy70Hp17BqWliTY7x4~MY23YlEuLtadfFPqcpePLd0nNN1SU3dFKbsGJF5u259dOb~vnLgY39vLq6hqzeHUTpnM~iLtVsl7xHSeWI4f5lPRBvY667fqmtRGRC67dHaVhHl5uVNygNFv2hd7mRQOGdFKQXuMgX2MBSXzaleAJdPqH~eSHEdnPRl4xIYvlwLk-j6BApXqh0IwDBR2deF86vfef3S~WiICIyENGAHr2NmXSbiRlq-UG2vN~zz6CCgotIXeYqYV5FpAZoHJ2snjIYwzF3PLEfcviUZusFpdQXp4xuGw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Karina",
            "Okay",
            "Wed",
            isVerified = false,
            isMute = false,
            null,
            isDone = true
        ),
        Chat(
            5L,
            "https://s3-alpha-sig.figma.com/img/a7ee/c493/c5583aefbe32da2d6a6286f76f7b2ad0?Expires=1671408000&Signature=BHFSLSCP7F8CvbzMWzW98Rj31NxMKYEEIS0P7R14D7X~s5Nkp0bOSeP~mP8DT5NerPL23H4xEP-YLTjngNiQYACPM4ELKcxcOrIBslG~eyiMNoGFKTmDM7P-EzaPmQuKl91Vv0ZHI7qISwBN89qeqmwPAiuVJKXv6KycqsaLuQ8s8E9RcbWF1sNClK7UsjjeBI8SGf2dkFtccky~mCqXp1Kqjkkl-f9fG~BxQr~3ZR1VNA~apBbGKHbMWTGtzcKz1dVez38fLx9vYTk1mle5akBBpmKsIHRfh0UPOCAUaSprdkBrU2V6cqn-f901XWwSFzzpwPkkubChr-1Y8PPx8g__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Marilyn",
            "Will it ever happen",
            "May 02",
            isVerified = false,
            isMute = false,
            null,
            isDone = true
        ),
        Chat(
            6L,
            "https://www.m24.ru/b/d/nBkSUhL2g1QhkMi2PqzJrMCqzJ3w-pun2XyQ2q2C_2OZcGuaSnvVjCdg4M4S7FjDvM_AtC_QbIk8W7zj1GdwKSGT_w=k3lxDIORmRc1byKBtbeYlQ.jpg",
            "Feud Sigmund",
            "my new book.",
            "May 01",
            isVerified = false,
            isMute = false,
            null,
            isDone = false
        ),
        Chat(
            7L,
            "https://cdnn1.img.armeniasputnik.am/img/07e5/03/1d/26970705_281:0:1319:1038_1920x0_80_0_0_f307fc11ed2dfb1baad4a8efc6a55865.jpg",
            "Alaska",
            "Landscape",
            "Feb 25",
            isVerified = false,
            isMute = false,
            null,
            isDone = true
        ),
        Chat(
            8L,
            "https://uberdeal.ru/wp-content/uploads/2019/08/1567240211_post_5464_thumbnail.png",
            "Кинопоиск",
            "Интерстеллар 2014",
            "Feb 20",
            isVerified = true,
            isMute = false,
            "Кино, сериалы",
            isDone = false
        ),
        Chat(
            9L,
            "https://www.shutterstock.com/shutterstock/photos/67016809/display_1500/stock-photo-light-brown-chihuahua-puppy-sitting-on-a-white-background-67016809.jpg",
            "Golden Chihuahua",
            "Riri 2022",
            "Jan 03",
            isVerified = false,
            isMute = false,
            null,
            isDone = false
        )
    )

    fun chatItem(): List<Chat> {
        return someList
    }

    fun remove(pos: Int) {
        someList.removeAt(pos)
    }

    fun addAll(newItems: List<Chat>) {
        someList.addAll(newItems)
    }
}

