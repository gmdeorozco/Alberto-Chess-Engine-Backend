package com.chess.boardserver.albertoEngine;

import java.util.Comparator;
import java.util.List;

import lombok.Data;

@Data
public class VirtualMove  {

    private char from;
    private char to;
    private Double valuation;
    private VirtualMove parent;
    private List<VirtualMove>  next;
    private boolean isLineEnd;
    private boolean isLinePaused;

}

class VirtualMoveComparator implements Comparator<VirtualMove> {
    @Override public int compare(VirtualMove vm1, VirtualMove vm2)
    {
        return (vm1.getValuation()).compareTo(vm2.getValuation());
    }
}
