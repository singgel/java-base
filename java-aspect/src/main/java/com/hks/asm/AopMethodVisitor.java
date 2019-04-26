package com.hks.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
/**
 * @Author: hekuangsheng
 * @Date: 2018/10/19
 *
 * 修改字节码
 */
public class AopMethodVisitor extends MethodVisitor implements Opcodes {

    public AopMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, "com/hks/asm/AopInteceptor", "before", "()V", false);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= IRETURN && opcode <= RETURN)
            // 在返回之前安插after 代码。
            this.visitMethodInsn(INVOKESTATIC, "com/hks/asm/AopInteceptor", "after", "()V", false);
        super.visitInsn(opcode);
    }

}
