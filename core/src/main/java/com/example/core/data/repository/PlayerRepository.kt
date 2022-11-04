//package com.example.core.data.repository
//
//import com.example.core.data.remote.datasource.PlayerRemoteDataSource
//import com.example.core.data.model.remote.players.PlayerSquad
//import com.example.core.data.model.remote.response.Response
//import javax.inject.Inject
//
//class PlayerRepository @Inject constructor(
//    private val playerRemoteDataSource: PlayerRemoteDataSource
//){
//    suspend fun refreshPlayers(): Response<List<PlayerSquad>> =
//        playerRemoteDataSource.refreshPlayers()
////    val players: Flow<List<UserListItem>> =
////        Transformations.map(database.usersDao.getDatabaseUsers()) {
////            it.asDomainModel()
////        }
////
////    suspend fun refreshUserList() {
////        try {
////            val users = userListService.getUserList()
////            database.usersDao.insertAll(users.asDatabaseModel())
////        } catch (e: Exception) {
////            Timber.w(e)
////        }
////    }
//}
