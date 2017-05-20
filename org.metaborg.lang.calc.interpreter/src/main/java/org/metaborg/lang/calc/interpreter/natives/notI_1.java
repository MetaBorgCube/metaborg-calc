package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.notI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class notI_1 extends TermBuild {

	public notI_1(SourceSection source) {
		super(source);
	}

	/**
	 * Return 1 if boolean = 0, else return 0.
	 * 
	 * @param i
	 * @return
	 */
	@Specialization
	public int doInt(int i) {
		if (i == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return notI_1NodeGen.create(source, stringbuild);
	}
}
