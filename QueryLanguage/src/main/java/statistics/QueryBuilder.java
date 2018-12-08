/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher copy = matcher;
        matcher = new All();
        return copy;
       
    }

    public QueryBuilder playsIn(String joukkue) {
        matcher = new And(this.matcher, new PlaysIn(joukkue));
        return this;
    }

    public QueryBuilder hasFewerThan(int n, String s) {
        matcher = new And(this.matcher, new HasFewerThan(n, s));
        return this;
    }

    public QueryBuilder hasAtLeast(int n, String s) {
        matcher = new And(this.matcher, new HasAtLeast(n, s));
        return this;
    }

    public QueryBuilder oneOf(Matcher...matchers) {
        matcher = new Or(matchers);
        return this;
    }
    

}
