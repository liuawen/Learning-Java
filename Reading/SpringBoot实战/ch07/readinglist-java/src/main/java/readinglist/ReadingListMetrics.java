package readinglist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Component
public class ReadingListMetrics implements PublicMetrics {

  private JdbcOperations jdbc;

  @Autowired
  public ReadingListMetrics(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }
  
  @Override
  public Collection<Metric<?>> metrics() {
    int count = jdbc.queryForObject(
        "select count(*) from Book", Integer.class);
    List<Metric<?>> metrics = new ArrayList<Metric<?>>();
    metrics.add(new Metric<Integer>("books.count", count));
    return metrics;
  }
  
}
