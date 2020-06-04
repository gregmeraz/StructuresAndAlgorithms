import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AncestralTreeAlgo {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        List<AncestralTree> ancestorsOfDescendantOne=getAncestors(descendantOne, topAncestor, new ArrayList<>());
        List<AncestralTree> ancestorsOfDescendantTwo=getAncestors(descendantTwo, topAncestor, new ArrayList<>());
        AncestralTree youngestCommonAncestor;
        if(ancestorsOfDescendantOne.size()>ancestorsOfDescendantTwo.size()){
            ancestorsOfDescendantOne.removeAll(ancestorsOfDescendantTwo);
            youngestCommonAncestor=getYoungestAncestor(ancestorsOfDescendantOne);
        }
        else if(ancestorsOfDescendantOne.size()<ancestorsOfDescendantTwo.size()){
            ancestorsOfDescendantTwo.removeAll(ancestorsOfDescendantOne);
            youngestCommonAncestor=getYoungestAncestor(ancestorsOfDescendantTwo);
        }
        else{
            youngestCommonAncestor=getYoungestAncestor(ancestorsOfDescendantOne);
        }

        return youngestCommonAncestor;
    }

    public static AncestralTree getYoungestAncestor(List<AncestralTree> commonAncestors){
        return commonAncestors.get(commonAncestors.size()-1);
    }

    public static List<AncestralTree> getAncestors(AncestralTree descendant, AncestralTree topAncestor, List<AncestralTree> ancestors){
       if(descendant==null){
           return ancestors;
       }
       if(descendant.equals(topAncestor)){
           return ancestors;
       }
        if(descendant.ancestor.equals(topAncestor)){
            ancestors.add(topAncestor);
            return ancestors;
        }
        else{
            ancestors.add(descendant.ancestor);
          return getAncestors(descendant.ancestor, topAncestor, ancestors);
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AncestralTree)) return false;
            AncestralTree that = (AncestralTree) o;
            return name == that.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
