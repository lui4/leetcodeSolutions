public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length - 1;
        int answer = 0;

        while (pointer1 < pointer2) {
            answer = Math.max(answer, (pointer2 - pointer1 + 1)*Math.min(height[pointer1], height[pointer2]));
            if(height[pointer1] < height[pointer2]){
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return answer;
    }
}
