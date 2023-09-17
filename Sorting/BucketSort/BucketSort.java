import java.util.ArrayList;
import java.util.Collections;

public class BucketSort 
{
    public void bucketSort(float[] arr, int n) 
    {
        if (n <= 0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        for (int i = 0; i < n; i++)
        bucket[i] = new ArrayList<Float>();

        for (int i = 0; i < n; i++) 
        {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) 
        {
            Collections.sort((bucket[i]));
        }

        int index = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0, size = bucket[i].size(); j < size; j++) 
            {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) 
    {
        BucketSort b = new BucketSort();
        float[] arr = { (float) 0.4242, (float) 0.3232, (float) 0.3533,(float) 0.5532, (float) 0.372, (float) 0.4427,(float) 0.51111 };
        b.bucketSort(arr, 7);

        for (float i : arr)
            System.out.print(i + "  ");
    }
}