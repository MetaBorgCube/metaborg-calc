package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.parseB_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class parseB_1 extends TermBuild {

	public parseB_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public java.math.BigDecimal doBigDecimal(String s) {
		return new java.math.BigDecimal(s);
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return parseB_1NodeGen.create(source, stringbuild); 
	}
}
