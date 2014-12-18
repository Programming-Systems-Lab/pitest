package org.pitest.coverage;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import org.pitest.testapi.Description;

public class CoverageResult implements Serializable {

  private static final long                 serialVersionUID = 1L;

  private final Description                 testUnitDescription;
  private final int                         executionTime;
  private final Collection<BlockLocation> visitedBlocks;
  private final boolean                     greenSuite;

  public CoverageResult(final Description testUnitDescription,
      final int executionTime, final boolean greenSuite,
      final Collection<BlockLocation> visitedBlocks) {
    this.testUnitDescription = testUnitDescription;
    this.executionTime = executionTime;
    this.visitedBlocks = visitedBlocks;
    this.greenSuite = greenSuite;
  }

  public Description getTestUnitDescription() {
    return this.testUnitDescription;
  }

  public int getExecutionTime() {
    return this.executionTime;
  }

  public Collection<BlockLocation> getCoverage() {
    if (!greenSuite)
      return new LinkedList<BlockLocation>();
    else
      return this.visitedBlocks;
  }

  public boolean isGreenTest() {
    return this.greenSuite;
  }
  
  public int getNumberOfCoveredBlocks() {
    if (!greenSuite)
      return 0;
    else
      return this.visitedBlocks.size();
  }

  @Override
  public String toString() {
    return "CoverageResult [testUnitDescription=" + this.testUnitDescription
        + ", executionTime=" + this.executionTime + ", coverage="
        + this.visitedBlocks + ", greenSuite=" + this.greenSuite + "]";
  }

}
