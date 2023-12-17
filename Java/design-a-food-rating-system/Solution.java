import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class FoodRatings {

    class Pair implements Comparable<Pair> {
        String food;
        int rating;
        String cuisine;

        public Pair(String f, String c, int r) {
            food = f;
            cuisine = c;
            rating = r;
        }

        public int compareTo(Pair p1) {
            if(this.rating != p1.rating)
                return p1.rating - this.rating;

            return this.food.compareTo(p1.food);
        }
    }
    private HashMap<String, PriorityQueue<Pair>> cuisineFoods = new HashMap<>();
    private HashMap<String, Pair> foodRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            Pair p = new Pair(foods[i], cuisines[i], ratings[i]);

            if(!cuisineFoods.containsKey(cuisines[i]))
                cuisineFoods.put(cuisines[i], new PriorityQueue<>());

            cuisineFoods.get(cuisines[i]).add(p);
            foodRating.put(foods[i], p);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = foodRating.get(food);
        Pair newP = new Pair(food, p.cuisine, newRating);
        p.food = "";

        foodRating.put(food, newP);
        cuisineFoods.get(p.cuisine).offer(newP);

    }
    
    public String highestRated(String cuisine) {
        String highestRatedFood = cuisineFoods.get(cuisine).peek().food;

        while(highestRatedFood.isBlank()) {
            cuisineFoods.get(cuisine).poll();
            highestRatedFood = cuisineFoods.get(cuisine).peek().food;
        }
        return highestRatedFood;
    }
}

public class Solution {
    public static void main(String[] args) {
         FoodRatings obj = new FoodRatings(new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, 
                                    new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                                    new int[] {9, 12, 8, 15, 14, 7});
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("sushi", 16);
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("ramen", 16);
        System.out.println(obj.highestRated("japanese"));   
    }
}
