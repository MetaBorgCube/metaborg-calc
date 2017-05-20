package org.metaborg.lang.calc.interpreter.natives;

import java.io.IOException;

import org.metaborg.lang.calc.interpreter.natives.getcharS_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class getcharS_1 extends TermBuild {

	public getcharS_1(SourceSection source) {
		super(source);
	}

	/**
	 * Read a character on input. Return an empty string on an end of file.
	 * 
	 * @param s Dummy parameter; I don't know how to hook up DynSem otherwise
	 * @return
	 * @throws IOException 
	 */
	@Specialization
	public String doString(String s) {
		try {
			return Character.toString((char) getContext().getInput().read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// TODO: Dummy return; I don't know how to do this properly in DynSem
		return "";
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return getcharS_1NodeGen.create(source, stringbuild);
	}
}
