
//package org.galagosearch.exercises;

import java.io.IOException;
import org.galagosearch.core.retrieval.structured.CountIterator;
import org.galagosearch.core.retrieval.structured.RequiredStatistics;
import org.galagosearch.core.retrieval.structured.ScoringFunctionIterator;
import org.galagosearch.tupleflow.Parameters;

/**
 * @Taheralsharif
 */
@RequiredStatistics(statistics = {"collectionLength", "documentCount"})
public class TFIDF extends ScoringFunctionIterator {
//*double b;
//double k;
double dl;
double idf;


public TFIDF(Parameters parameters, CountIterator iterator) throws IOException
{
super(iterator);
// Implement the constructor

/**
b = parameters.get("b", 0.75D);
k = parameters.get("k", 1.2D);
long collectionLength = parameters.get("collectionLength",0L);
long fi = parameters.get("documentCount", 0L);
dl = (collectionLength + 0.0) / (fi+ 0.0);
long df = 0;
if (parameters.containsKey("df")) {
df = parameters.get("df", 0L);
} 
else {
df = iterator.count();
}
idf = Math.log((fi - df + 0.5) / (df + 0.5));


}
*/



/**
* @param count equals to fi
* @param length equals to dl
* Ignores ((k2+1)qfi)  / (k2+qfi) because the performance is less sensitive.
* Only calculate ((k1+1)fi ) / (K + fi)
*/
@Override
public double scoreCount(int count, int length) {

// Implement this method
double topequ = count * (k + 1);
double bottomequ = count + (k * (1 - b + (b* length / dl)));
 
return idf * (topequ / bottomequ);
 




// you will need to modify this
}
}
