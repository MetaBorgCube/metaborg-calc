package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.debug_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "print", type = TermBuild.class)
public abstract class debug_1 extends TermBuild {
    public debug_1(SourceSection source) {
        super(source);
    }

    @Specialization
    public Object doInt(Object s) {
        System.err.println(s);
        
        return s;
    }

    public static TermBuild create(SourceSection source, TermBuild print) {
        return debug_1NodeGen.create(source, print);
    }
}
