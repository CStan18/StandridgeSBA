# StandridgeSBA
Java Bootcamp SMS SBA

@author Caleb Standridge
@date 1/16/23

**The database will be populated for you.** 
**If you already have the database in Workbench you can still run it.**

main() path: StandridgeSBA/StandridgeSMS/src/main/sba/App.java

How to run:
1. Download the zip or clone the Git repository.
---------------------------------------------
2. Unzip the zip file (if you downloaded one)
---------------------------------------------
3. Open Spring
---------------------------------------------
4. File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
---------------------------------------------
5. DB information is in hibernate.cfg.xml, please change accordingly.
<property name="connection.url">jdbc:mariadb://localhost:3306/smsdb</property>
<property name="connection.username">user1</property>
<property name="connection.password">user1</property>
---------------------------------------------
6. Run \StandridgeSMS\src\main\java\sba\App.java as Java Application
---------------------------------------------
8. Spring may warn you there are errors, you can run anyway.
---------------------------------------------
10. However, if you run the tests you may need to add JUnit 4 to the build path.
---------------------------------------------
12. This does not happen locally, only when retrieved/cloned from GitHub.

