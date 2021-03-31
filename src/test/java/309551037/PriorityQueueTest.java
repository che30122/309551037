import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest{
    public static Stream<Arguments> getParameters(){
        return Stream.of(arguments(new int[]{1,4,3,2},new int[]{1,2,3,4}),
                arguments(new int[]{4,9,5,7},new int[]{4,5,7,9}),
		arguments(new int[]{-1,-4,0,1,4},new int[]{-4,-1,0,1,4}),
		arguments(new int[]{-10000,-20000,-4,-1000},new int[]{-20000,-10000,-1000,-4}),
		arguments(new int[]{0,0,0},new int[]{0,0,1})
        );
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void  PriorityQueue_RunTest(int[] input,int[] answer){
        PriorityQueue pq=new PriorityQueue();
        for(int i:input){
            pq.offer(i);
        }

        for(int i:answer){
            assertEquals(i,pq.poll());
        }
    }

    @Test
    public void illegalArgument(){
        Exception exception=assertThrows(IllegalArgumentException.class,()->{
            PriorityQueue pq=new PriorityQueue(-1);
        });

    }

    @Test
    public void nullPointer(){
        Exception exception=assertThrows(NullPointerException.class,()->{
            PriorityQueue pq=new PriorityQueue();
            pq.add(null);
        });

    }

    @Test
    public void foreachTest(){
        Exception exception=assertThrows(NullPointerException.class,()->{
            new PriorityQueue().forEach(null);
        });

    }

}
