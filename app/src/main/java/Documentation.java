/**
 * Created by skyla on 9/8/2016.
 */
public class Documentation {
}

/*

ISSUE #1
    when creating project, i get error (
        Error:Unable to start the daemon process. This problem might be caused by incorrect
            configuration of the daemon. For example, an unrecognized jvm option is used.
            Please refer to the user guide chapter on the daemon at

altho my settings were already:-
    as answer provided here
    http://stackoverflow.com/questions/30045417/android-studio-gradle-could-not-reserve-enough-space-for-object-heap

    it still failed,
    so i installed jaba 1.81, changed SDK to this new loc, and it works now.



ISSUE#2

when adding notification builder code, i get error
    Error:(25, 40) error: incompatible types: android.support.v4.app.NotificationCompat.Builder cannot be converted to android.support.v7.app.NotificationCompat.Builder


in code added v4, commented of v7
//import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationCompat;



FEATURE #1

Added SQLLite (copied based on tutorials from)
    http://www.tutorialspoint.com/android/android_sqlite_database.htm

 */



