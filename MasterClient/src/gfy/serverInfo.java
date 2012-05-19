package gfy;

import com.sun.management.OperatingSystemMXBean;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.text.NumberFormat;

/**
 *
 * @author Janssen-laptop
 */
public class serverInfo implements Serializable {

  private long maxMemory;
  private long allocatedMemory;
  private long freeMemory;
  private double cpuAPP;
  private double cpu;

  public serverInfo() {
  }

  public void getInfo() {
    Runtime runtime = Runtime.getRuntime();
    maxMemory = runtime.maxMemory();
    allocatedMemory = runtime.totalMemory();
    freeMemory = runtime.freeMemory();
    
    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
    OperatingSystemMXBean.class);
 
    
    cpuAPP = osBean.getProcessCpuLoad();
    cpu = osBean.getSystemCpuLoad();
  }

  /**
   * @return the maxMemory
   */
  public long getMaxMemory() {
    return maxMemory;
  }

  /**
   * @param maxMemory the maxMemory to set
   */
  public void setMaxMemory( long maxMemory ) {
    this.maxMemory = maxMemory;
  }

  /**
   * @return the allocatedMemory
   */
  public long getAllocatedMemory() {
    return allocatedMemory;
  }

  /**
   * @return the freeMemory
   */
  public long getFreeMemory() {
    return freeMemory;
  }

  /**
   * @return the cpuAPP
   */
  public double getCpuAPP() {
    return cpuAPP;
  }

  /**
   * @return the cpu
   */
  public double getCpu() {
    return cpu;
  }
}
