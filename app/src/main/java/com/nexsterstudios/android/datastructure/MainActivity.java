package com.nexsterstudios.android.datastructure;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.nexsterstudios.android.datastructure.databinding.ActivityMainBinding;
import com.nexsterstudios.android.datastructure.tree.Ds;
import com.nexsterstudios.android.datastructure.tree.binarySearchTree.BinarySortedTree;
import com.nexsterstudios.android.datastructure.tree.binarySearchTree.bottomView.BinarySortedTreeL;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*BinarySortedTree binarySortedTree = new BinarySortedTree();
        binarySortedTree.insert(6);
        binarySortedTree.insert(4);
        binarySortedTree.insert(8);
        binarySortedTree.insert(3);
        binarySortedTree.insert(5);
        binarySortedTree.insert(7);
        binarySortedTree.insert(9);

        binarySortedTree.traverseUsingInOrder(binarySortedTree.getNode());
        binarySortedTree.traverseUsingPreOrder(binarySortedTree.getNode());
        binarySortedTree.traverseUsingPostOrder(binarySortedTree.getNode());
        binarySortedTree.traverseLevelOrder(binarySortedTree.getNode());
        */

        BinarySortedTreeL bt = new BinarySortedTreeL();
        bt.insert(4);
        bt.insert(7);
        bt.insert(2);
        bt.insert(11);
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
//        bt.insert(1);
//        bt.insert(0);
//        bt.insert(-1);


        setSupportActionBar(binding.toolbar);

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    int number = Integer.valueOf(binding.viewParent.input.getText().toString().trim());
//                    binarySortedTree.insert(number);
//                    Log.d(TAG, "onClick: "+number+" added.");
//                    bt.printLeftView_online(bt.getNode());
//                    bt.printRightViewWithLevelOrder(bt.getNode(),1);
//                    bt.traverseUsingPreOrder(bt.getNode());
                    bt.printBoundry(bt.getNode());

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "enter valid number", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        /*        try {
                    int number = Integer.valueOf(binding.viewParent.input.getText().toString().trim());
//                    binarySortedTree.delete(number);
                    Log.d(TAG, "onClick: " + number + " deleted.");
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "enter valid number", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                String[] data = {"knee","aba","silent","bca","keen","listen"};

                Ds ds = new Ds();
//                int count = ds.findGroupOfAnagram(data);
                boolean status = ds.isAnagram2("knee", "kenn");

            }
        });
        binding.find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int number = Integer.valueOf(binding.viewParent.input.getText().toString().trim());
//                    Log.d(TAG, "onClick: "+number+" found status : "+binarySortedTree.find(number));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "enter valid number", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}