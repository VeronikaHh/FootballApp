Football application(single activity).
Mutli module app, MVVM+clean architecture.
<img width="776" alt="architecture" src="https://user-images.githubusercontent.com/74206053/219855707-3acc52c8-7325-4250-a918-a73e1760724b.png">

API: https://www.api-football.com/documentation-v3
Using Retrofit for network, Hilt for DI, Room for local database.

Example of deep link for:
 - team screen - app.com/football/team/teamId=541
 - player screen - app.com/football/player/player=276/team=85
 - head to head(compare two teams) screen - app.com/football/h2h/firstTeamId=541/secondTeamId=529
Splash screen


Compare screen
<img width="135" alt="compare" src="https://user-images.githubusercontent.com/74206053/219856276-5ccf97f8-3ac3-4da5-8e2d-26df13741ab5.png">

Search team
<img width="189" alt="search" src="https://user-images.githubusercontent.com/74206053/219856469-e6d48c7d-2780-47c7-8fc9-84be97329e15.png">
<img width="188" alt="cmppng" src="https://user-images.githubusercontent.com/74206053/219856516-724a9691-17ae-40a5-aa40-b29ed0dac4ba.png">
<img width="186" alt="2" src="https://user-images.githubusercontent.com/74206053/219856548-5346ff26-ce18-4057-9b59-5861f676f2c7.png">

After pressing "compare" button, go to head to head screen, where we see statistcs for matchet between these team
<img width="573" alt="h2h" src="https://user-images.githubusercontent.com/74206053/219857193-831a4b9e-2fed-4cb3-a631-d6af1d97b23f.png">

After pressing on logo of team we go to team statistics screen
<img width="768" alt="team" src="https://user-images.githubusercontent.com/74206053/219856952-ddcfff88-33eb-49e0-be0e-f7c745c3d4f4.png">

Also we can check statistics of any player
<img width="330" alt="player" src="https://user-images.githubusercontent.com/74206053/219857111-7038fee6-6928-4258-a8bd-724a4e1e8e2d.png">
