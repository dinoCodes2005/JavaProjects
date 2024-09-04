import java.util.HashSet;
import java.util.Set;

public class robotSimulatoin {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        //stores the direction
        //N - S - E - W
        int directionX[] = {0,1,0,-1};
        int directionY[] = {1,0,-1,0};
        //initial points 
        int xi=0,yi=0;

        //final points
        int xf=0,yf=0;

        int obstacleIndex=0;

        int d=0;
        double result = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for(int[] obstacle:obstacles)
        {
            //storing the obstacle indexes in the hashSet 
            //0 --> x coordinate of the obstacle
            //1 --> y coordinate of the obstacle
            //the obstacle is stored like {2 4} in the form of String in hashSet
            set.add(obstacle[0]+" "+obstacle[1]);
        }

        for(int i=0;i<commands.length;i++)
        {

            if(commands[i]==-1)
            {
                //turn direction 
                //-1 --> right
                    d=(d+1)%4;
            }

            else if(commands[i]==-2)
            {
                //turn direction 
                // -2 --> left
                d=(d-1+4)%4; 
            }

            else
            {
                int k=commands[i];
                // move forward by k units one at a time
                for(int j=0;j<k;j++)
                {
                    if(!set.contains(xf+directionX[d]+" "+(yf+directionY[d])))
                    {
                        xf+=directionX[d];
                        yf+=directionY[d];
                    }
                    else
                    break;
                }
                result =Math.max(result, Math.pow(xf,2)+Math.pow(yf,2));
            }
        }
        return (int)result;
    }
    public static void main(String[] args) {
        robotSimulatoin obj = new robotSimulatoin();
        int commands[] ={4,-1,4,-2,4};
        int obstacles[][] = {{2,4}};
        System.out.println(obj.robotSim(commands,obstacles));
    }
}
