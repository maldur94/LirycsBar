package com.maldur94.database

private const val DATABASE_NAME = "LirycsBar Database"

//@Database(
//    entities = [Liryc::class],
//    version = 1,
//    exportSchema = false
//)
//@TypeConverters(DatabaseTypeConverters::class)
//abstract class DatabaseManager : RoomDatabase() {
//
//    abstract val lirycsDao: LirycsDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: DatabaseManager? = null
//
//        fun getDatabase(context: Context): DatabaseManager {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) return tempInstance
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    DatabaseManager::class.java,
//                    DATABASE_NAME
//                )
//                    .allowMainThreadQueries()
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}
