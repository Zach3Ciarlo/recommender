import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recommender {
    public static void main(String[] args) throws Exception {
        System.out.println("Running Recommender...");
        createMovieList();
        createUserList();
    }

    /**
     * CONDITIONS: 
     *      There are X movies in the txt file...
     *      There are Y attributes per movie...
     * Read info from movies.txt to make a movie object to be stored in an array. 
     * @return an array of movie objects.
     */
    public static Movie[] createMovieList(){
        
        int movieNum = 5;
        int movieGenres = 9;
        Movie[] movieArr = new Movie[movieNum];
        String[][] allMovies = new String[movieNum][movieGenres];
        File movies = new File("./lib/movies.txt");
        try {
            Scanner readGenres = new Scanner(movies);
            for(int i = 0; i < movieNum; i++){
                for(int j = 0; j < movieGenres; j++){
                   allMovies[i][j] =  readGenres.nextLine();
                   System.out.println(allMovies[i][j]);
                }
                Movie nextMovie = new Movie(allMovies[i]);
                movieArr[i] = nextMovie;

            }
        } catch (FileNotFoundException e) {
           System.out.print("Error with movies file");
            e.printStackTrace();
        }
        
        return movieArr;
    }


    /**
     * CONDITIONS: 
     *      There are N users in the txt file...
     *      There are Y attributes per user...
     * Read info from users.txt file to create N user objects. 
     * @return an array of user objects.
     */
    public static User[] createUserList(){
        
        int userNum = 5;
        int userGenreRatings = 9;
        User[] userArr = new User[userNum];
        String[][] allUsers = new String[userNum][userGenreRatings];
        File users = new File("./lib/users.txt");
        try {
            Scanner readRatings = new Scanner(users);
            for(int x = 0; x < userNum; x++){
                for(int y = 0; y < userGenreRatings; y++){
                allUsers[x][y] = readRatings.nextLine();
                    System.out.println(allUsers[x][y]);
                }
                User nextUser = new User(allUsers[x]);
                userArr[x] = nextUser;
            }
        
        } catch (FileNotFoundException e) {
           System.out.print("Error with users file");
            e.printStackTrace();
        }
        return userArr;
    }

    public static Rating[] createRatingList(){
        int userNum = 5;
        int userRatings = 15;
        Rating[] ratingArr = new Rating[userNum];
        String[][] allRatings = new String[userNum][userRatings];
        File ratings = new File("./lib/userRatings.txt");
        try {
            Scanner readScores = new Scanner(ratings);
            for(int a = 0; a < userNum; a++){
                for(int b = 0; b < userRatings; b++){
                    allRatings[a][b] = readScores.nextLine();
                    System.out.println(allRatings[a][b]);
                }
                Rating nextRating = new Rating(allRatings[a]);
                ratingArr[a] = nextRating;
            }
        } catch (FileNotFoundException e) {
            System.out.print("Error with ratings file");
            e.printStackTrace();
        }
        return ratingArr;
    }
}
