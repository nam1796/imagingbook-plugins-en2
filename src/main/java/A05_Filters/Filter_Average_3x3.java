/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 *  image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2016 Wilhelm Burger, Mark J. Burge. All rights reserved. 
 * Visit http://imagingbook.com for additional details.
 *******************************************************************************/
package A05_Filters;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Filter_Average_3x3 implements PlugInFilter {

    public int setup(String arg, ImagePlus imp) {
        return DOES_8G;
    }

    public void run(ImageProcessor orig) {
        int M = orig.getWidth();
        int N = orig.getHeight(); 
        ImageProcessor copy = orig.duplicate();

		for (int u = 1; u <= M - 2; u++) {
			for (int v = 1; v <= N - 2; v++) {
                //compute filter result for position (u, v):
                int sum = 0;
                for (int i = -1; i <= 1; i++) {
                	for (int j = -1; j <= 1; j++) {
						int p = copy.getPixel(u + i, v + j);
                        sum = sum + p;
                    }
                }
                int q = (int) (sum / 9.0);
				orig.putPixel(u, v, q);
            }
        }
    }

}
