package WordCount1;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{

  @Override
  public void map(LongWritable key, Text value, Context con)
      throws IOException, InterruptedException 
  {
	  String line = value.toString();
	  String[] words = line.split("\\s");
	  for(String s:words) 
	  {
              con.write(new Text(s), new IntWritable(1));
	  }
  }
}
