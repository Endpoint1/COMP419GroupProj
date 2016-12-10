package org.galagosearch.exercises;

import java.io.IOException;
import org.galagosearch.core.retrieval.structured.CountIterator;
import org.galagosearch.core.retrieval.structured.RequiredStatistics;
import org.galagosearch.core.retrieval.structured.ScoringFunctionIterator;
import org.galagosearch.tupleflow.Parameters;

/**
 * @author Your Name
 */
@RequiredStatistics(statistics = {"collectionLength", "documentCount"})
public class BM25Iterator extends ScoringFunctionIterator {
 double documentCount;   // same as bigN
 double bigN;
 double inverseni; // initialized in idf()
 double fi; //comes from iterator.count()... we think.
 double tf; //initialized in tfCompute()
 double idf; //initialized in idfCompute()
 double tfidf; //initialized in tfIdfCompute()

 public BM25Iterator(Parameters parameters, CountIterator iterator) throws IOException
 {
  super(iterator);

  documentCount = parameters.get("documentCount", 100000); // retrieve N
  while(!iterator.isDone()) {
    ni += 1;
    iterator.nextDocument();
  }
  iterator.reset();

  tfIdfCompute();
 }

public void tfIdfCompute(){
  bigN = documentCount;
  fi = iterator.count();
  tf = fi / bigN;
  idf = Math.log(bigN / fi);
  tfif = tf * idf;
}

 /**
  * @param count equals to fi
  * @param length equals to dl
*/
 @Override
 public double scoreCount(int count, int length) {
  return count;
 }
}
