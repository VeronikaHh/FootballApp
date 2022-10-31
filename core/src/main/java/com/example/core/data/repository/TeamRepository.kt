//package com.example.core.data.repository
//
//import com.example.core.data.database.FootballDatabase
//import com.example.core.data.service.TeamService
//import javax.inject.Inject
//
//class TeamRepository @Inject constructor(
//    private val teamService: TeamService,
//    private val database: FootballDatabase
//){
////    val teams: LiveData<List<>> =
////        Transformations.map(database.TeamDao.getTeamList()) {
////            it.asDomainModel()
////        }
////
////    suspend fun refreshUserList() {
////        try {
////            val teams = userListService.getUserList()
////            database.usersDao.insertAll(users.asDatabaseModel())
////        } catch (e: Exception) {
////            Timber.w(e)
////        }
////    }
//}