package com.example.imagen;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Triangle extends Shape {
    private FloatBuffer mFVertexBuffer, mFColorBuffer;
    private ByteBuffer mIndexBuffer;
    private FloatBuffer colors;

    public Triangle() {
        float[] mColorArray = {
                0f, 1f, 1f, 0f, //rojo
                0f, 1f, 0f, 1f, //verde
                0f, 0f, 1f, 1f, //azul
                1f, 0f, 1f, 1f, //rojo+azul
                0f, 1f, 1f, 1f //verde+azul
        };
        float vertices[] = {
                0f, 1f, 0f,
                -1f, -1f, 0f,
                1f, -1f, 0f
        };
        mFVertexBuffer = buildFloatBuffer(vertices);
        mFColorBuffer = buildFloatBuffer(mColorArray);
    }

    private static FloatBuffer buildFloatBuffer(float[] arr) {
        ByteBuffer bb = ByteBuffer.allocateDirect(arr.length *
                4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);
        return fb;
    }

    public void draw(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0,
                mFVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mFColorBuffer);
        //gl.glDrawElements(GL10.GL_TRIANGLES, 3, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }
}
