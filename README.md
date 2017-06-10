Here I try to create a minimal reproducible case for:
https://github.com/nidi3/graphviz-java/compare/master...ScalaWilliam:attempt-jdk-error?expand=1

That code tries to use the latest version of vizjs.

However it seems to work. The error I get there, when running `mvn -Dtest=EngineTest test`, is:

```
[INFO] Running guru.nidi.graphviz.engine.EngineTest
Exception in thread "Thread-3" java.lang.VerifyError: Bad local variable type
Exception Details:
  Location:
    jdk/nashorn/internal/scripts/Script$Recompilation$11$11245AAAA$viz_1_8_0.L:22$Module$allocate(Ljdk/nashorn/internal/runtime/ScriptFunction;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; @544: aload
  Reason:
    Type double_2nd (current frame, locals[6]) is not assignable to reference type
  Current Frame:
    bci: @544
    flags: { }
    locals: { 'jdk/nashorn/internal/runtime/ScriptFunction', 'java/lang/Object', 'java/lang/Object', 'java/lang/Object', 'java/lang/Object', double, double_2nd, top, 'java/lang/Double', 'jdk/nashorn/internal/runtime/ScriptObject', integer, 'java/lang/Object', 'java/lang/Object', 'java/lang/Object', 'java/lang/Object' }
    stack: { }
  Bytecode:
    0x0000000: b801 123a 0619 053a 082a b600 143a 0919
    0x0000010: 0603 0454 2c01 b800 1a12 1cb8 0020 9900
    0x0000020: 1104 360a 2c3a 0b19 0604 0454 a700 1303
    0x0000030: 360a 2cba 002b 0000 3a0b 1906 0504 542d
    0x0000040: 01b8 001a 122d b800 2099 000c 2d19 0606
    0x0000050: 0454 a700 0901 1906 0704 543a 0c19 0419
    0x0000060: 09ba 0031 0000 b800 3499 000f 1908 3a0d
    0x0000070: 1906 0804 54a7 00f0 03b8 0038 3a17 1917
    0x0000080: 0319 0912 3ab8 001a 123c b800 2099 0013
    0x0000090: 1909 ba00 3f00 0019 0610 0604 54a7 0015
    0x00000a0: 1909 ba00 4200 00ba 0045 0000 1906 1007
    0x00000b0: 0454 5319 1704 1909 ba00 4200 00ba 0048
    0x00000c0: 0000 5319 1705 1909 ba00 4200 00ba 0045
    0x00000d0: 0000 5319 1706 1909 ba00 4200 00ba 004b
    0x00000e0: 0000 5319 17b8 0051 5919 0419 09b6 0056
    0x00000f0: b600 56ba 0059 0000 b800 2099 0013 1909
    0x0000100: ba00 5c00 0019 0610 0804 54a7 000b 1904
    0x0000110: 1906 1009 0454 ba00 5f00 005f 1909 b600
    0x0000120: 56b6 0056 ba00 6200 0059 ba00 6500 005f
    0x0000130: 190b 190c b800 6b99 0010 04b8 0071 1906
    0x0000140: 100a 0454 a700 0f2d ba00 2b00 0019 0610
    0x0000150: 0b04 54ba 0075 0000 ba00 7900 003a 0d19
    0x0000160: 0610 0c04 5415 0a99 00cb 190d 3a08 1909
    0x0000170: ba00 7c00 00b2 0080 190d b800 8406 7e03
    0x0000180: 9f00 0d03 1906 100d 0454 a700 0a04 1906
    0x0000190: 100e 0454 ba00 8800 0057 190d 190b b800
    0x00001a0: 8410 fc7e b800 71b8 008b 3a0e 1906 100f
    0x00001b0: 0454 1908 190e b800 8e99 002b 1909 ba00
    0x00001c0: 9100 0019 08b8 0084 057a 03ba 0095 0000
    0x00001d0: 1908 07b8 0071 b800 8b3a 0819 0610 1004
    0x00001e0: 54a7 ffd1 190d 190b b800 8b3a 0e19 0610
    0x00001f0: 1104 5419 0819 0eb8 008e 9900 2f19 09ba
    0x0000200: 0098 0000 1908 b800 9c5c 0f63 3905 b800
    0x0000210: a103 7a03 ba00 9500 0018 05b8 00a6 3a08
    0x0000220: 1906 1012 0454 a7ff cd19 0d19 0610 1304
    0x0000230: 54b0 190c 12a9 b800 2099 0082 2cba 00ac
    0x0000240: 0000 b800 6b99 000c 1906 1014 0454 a700
    0x0000250: 152c ba00 af00 00b8 006b 9900 2919 0610
    0x0000260: 1504 5419 09ba 00b2 0000 59ba 00b5 0000
    0x0000270: 5f2c 190d ba00 b800 0057 1906 1016 0454
    0x0000280: a700 3219 09ba 00b2 0000 59ba 00b5 0000
    0x0000290: 5f19 09b6 0056 b600 56ba 00bb 0000 2cba
    0x00002a0: 00be 0000 190d ba00 b800 0057 1906 1017
    0x00002b0: 0454 190d 1906 1018 0454 b003 360f b200
    0x00002c0: 803a 16b2 0080 3a13 150f b800 713a 12b2
    0x00002d0: 0080 3a14 b200 803a 1519 0610 1904 5419
    0x00002e0: 1219 0bb8 008e 9901 092c 1912 ba00 c300
    0x00002f0: 003a 1619 1601 b800 1a12 3cb8 0020 9a00
    0x0000300: 0c19 0610 1a04 54a7 0020 1909 ba00 4200
    0x0000310: 0059 ba00 c600 005f 1916 ba00 c900 003a
    0x0000320: 1619 0610 1b04 5419 0c59 b800 6b99 000c
    0x0000330: 1906 101c 0454 a700 1257 2d19 12ba 00c3
    0x0000340: 0000 1906 101d 0454 3a13 1913 b800 cc03
    0x0000350: 8798 9a00 1c19 12b8 009c 0f63 3910 1810
    0x0000360: b800 a63a 1219 0610 1e04 54a7 ff74 1913
    0x0000370: 12ce b800 349a 000c 1906 101f 0454 a700
    0x0000380: 1012 d0b8 00d4 3a13 1906 1020 0454 1909
    0x0000390: ba00 d800 00b2 0080 190d 1912 b800 8b19
    0x00003a0: 1619 13ba 00dc 0000 5719 1519 13b8 00df
    0x00003b0: 9a00 0c19 0610 2104 54a7 0024 1909 ba00
    0x00003c0: 4200 0059 ba00 e200 005f 1913 ba00 e500
    0x00003d0: 003a 1419 133a 1519 0610 2204 5419 1219
    0x00003e0: 14b8 008b 3a12 1906 1023 0454 a7fe f319
    0x00003f0: 0d19 0610 2404 54b0                    
  Stackmap Table:
    full_frame(@47,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83]},{})
    append_frame(@63,Integer,Object[#248])
    same_frame(@85)
    same_locals_1_stack_item_frame(@91,Object[#248])
    append_frame(@120,Object[#248])
    full_frame(@160,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#249],Integer})
    full_frame(@178,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#249],Integer,Object[#248]})
    full_frame(@270,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#251],Object[#251]})
    full_frame(@278,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#251],Object[#251],Object[#248]})
    full_frame(@327,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#248],Object[#251],Object[#248],Object[#248],Object[#248]})
    full_frame(@339,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#249]},{Object[#248],Object[#251],Object[#248],Object[#248],Object[#248],Object[#248]})
    full_frame(@357,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248]},{})
    full_frame(@397,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248]},{Object[#248],Object[#253]})
    full_frame(@404,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248]},{Object[#248],Object[#253],Integer})
    append_frame(@434,Object[#248])
    same_frame(@484)
    full_frame(@499,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Top,Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248],Object[#248]},{})
    same_frame(@553)
    full_frame(@562,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248]},{})
    same_frame(@593)
    same_frame(@611)
    same_frame(@643)
    same_frame(@690)
    same_frame(@699)
    full_frame(@735,{Object[#16],Object[#248],Object[#248],Object[#248],Object[#248],Object[#248],Object[#276],Top,Object[#248],Object[#83],Integer,Object[#248],Object[#248],Object[#248],Top,Integer,Top,Top,Object[#248],Object[#248],Object[#248],Object[#248],Object[#248]},{})
    same_frame(@778)
    same_frame(@807)
    same_locals_1_stack_item_frame(@825,Object[#248])
    same_locals_1_stack_item_frame(@840,Object[#248])
    same_frame(@878)
    same_frame(@897)
    same_frame(@910)
    same_frame(@956)
    same_frame(@989)
    same_frame(@1007)

        at java.lang.Class.getDeclaredFields0(Native Method)
        at java.lang.Class.privateGetDeclaredFields(Class.java:2583)
        at java.lang.Class.getDeclaredField(Class.java:2068)
        at jdk.nashorn.internal.runtime.Context$ContextCodeInstaller$1.run(Context.java:209)
        at jdk.nashorn.internal.runtime.Context$ContextCodeInstaller$1.run(Context.java:204)
        at java.security.AccessController.doPrivileged(Native Method)
        at jdk.nashorn.internal.runtime.Context$ContextCodeInstaller.initialize(Context.java:204)
        at jdk.nashorn.internal.codegen.CompilationPhase$InstallPhase.transform(CompilationPhase.java:508)
        at jdk.nashorn.internal.codegen.CompilationPhase.apply(CompilationPhase.java:624)
        at jdk.nashorn.internal.codegen.Compiler.compile(Compiler.java:655)
        at jdk.nashorn.internal.runtime.RecompilableScriptFunctionData.compileTypeSpecialization(RecompilableScriptFunctionData.java:725)
        at jdk.nashorn.internal.runtime.RecompilableScriptFunctionData.getBest(RecompilableScriptFunctionData.java:905)
        at jdk.nashorn.internal.runtime.ScriptFunctionData.getBest(ScriptFunctionData.java:375)
        at jdk.nashorn.internal.runtime.ScriptFunctionData.getBestInvoker(ScriptFunctionData.java:237)
        at jdk.nashorn.internal.runtime.ScriptFunction.findCallMethod(ScriptFunction.java:871)
        at jdk.nashorn.internal.runtime.ScriptObject.lookup(ScriptObject.java:1825)
        at jdk.nashorn.internal.runtime.linker.NashornLinker.getGuardedInvocation(NashornLinker.java:104)
        at jdk.nashorn.internal.runtime.linker.NashornLinker.getGuardedInvocation(NashornLinker.java:98)
        at jdk.internal.dynalink.support.CompositeTypeBasedGuardingDynamicLinker.getGuardedInvocation(CompositeTypeBasedGuardingDynamicLinker.java:176)
        at jdk.internal.dynalink.support.CompositeGuardingDynamicLinker.getGuardedInvocation(CompositeGuardingDynamicLinker.java:124)
        at jdk.internal.dynalink.support.LinkerServicesImpl.getGuardedInvocation(LinkerServicesImpl.java:154)
        at jdk.internal.dynalink.DynamicLinker.relink(DynamicLinker.java:253)
        at jdk.nashorn.internal.scripts.Script$Recompilation$8$viz_1_8_0.:scopeCall-2(file:/Users/me/Projects/graphviz-java/target/classes/viz-1.8.0.js)
        at jdk.nashorn.internal.scripts.Script$Recompilation$8$viz_1_8_0.L:22$Module$:split(file:/Users/me/Projects/graphviz-java/target/classes/viz-1.8.0.js:27)
        at jdk.nashorn.internal.scripts.Script$Recompilation$7$640A$viz_1_8_0.L:22$Module(file:/Users/me/Projects/graphviz-java/target/classes/viz-1.8.0.js:27)
        at jdk.nashorn.internal.scripts.Script$Recompilation$6$2392760AAAAA$viz_1_8_0.L:22$render(file:/Users/me/Projects/graphviz-java/target/classes/viz-1.8.0.js:80)
        at jdk.nashorn.internal.scripts.Script$Recompilation$5$2391703A$viz_1_8_0.L:22$Viz(file:/Users/me/Projects/graphviz-java/target/classes/viz-1.8.0.js:75)
        at jdk.nashorn.internal.scripts.Script$4$\^eval\_.:program(<eval>:1)
        at jdk.nashorn.internal.runtime.ScriptFunctionData.invoke(ScriptFunctionData.java:637)
        at jdk.nashorn.internal.runtime.ScriptFunction.invoke(ScriptFunction.java:494)
        at jdk.nashorn.internal.runtime.ScriptRuntime.apply(ScriptRuntime.java:393)
        at jdk.nashorn.api.scripting.NashornScriptEngine.evalImpl(NashornScriptEngine.java:446)
        at jdk.nashorn.api.scripting.NashornScriptEngine.evalImpl(NashornScriptEngine.java:403)
        at jdk.nashorn.api.scripting.NashornScriptEngine.evalImpl(NashornScriptEngine.java:399)
        at jdk.nashorn.api.scripting.NashornScriptEngine.eval(NashornScriptEngine.java:155)
        at javax.script.AbstractScriptEngine.eval(AbstractScriptEngine.java:264)
        at guru.nidi.graphviz.engine.GraphvizJdkEngine.doInit(GraphvizJdkEngine.java:66)
        at guru.nidi.graphviz.engine.AbstractGraphvizEngine.init(AbstractGraphvizEngine.java:59)
        at java.lang.Thread.run(Thread.java:745)

```



# This project

Even with assertions on, it succeeds: `MAVEN_OPTS="-ea" mvn test`.