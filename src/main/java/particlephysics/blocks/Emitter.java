package particlephysics.blocks;

import java.util.ArrayList;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import particlephysics.ModParticlePhysics;
import particlephysics.ParticleRegistry;
import particlephysics.Settings;
import particlephysics.tile.EmitterTileEntity;
import particlephysics.utils.BasicComplexBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class Emitter extends BasicComplexBlock
{

    public Emitter()
    {
        super(Settings.Emitter);
    }

    public Emitter(int i)
    {
        super(i);
    }

    @Override
    public String getFront()
    {
        // TODO Auto-generated method stub
        return "Emitter";
    }

    @Override
    public boolean hasModel()
    {
        return true;
    }

    @Override
    public String getTop()
    {
        // TODO Auto-generated method stub
        return "EmitterTop";
    }

    @Override
    public Class getTileEntityClass()
    {
        return EmitterTileEntity.class;
    }

    @Override
    public void addRecipe()
    {
        GameRegistry.addRecipe(new ItemStack(this), "I  ", "IID", "I  ", 'I', new ItemStack(Item.ingotIron), 'D', new ItemStack(Item.diamond));

    }

    @Override
    public String getName()
    {
        return "Emitter";
    }

    @Override
    public boolean hasItemBlock()
    {
        return true;
    }

    @Override
    public Class getItemBlock()
    {
        return null;

    }

    @Override
    public boolean topSidedTextures()
    {
        return true;
    }

    @Override
    public void registerIcons(IconRegister icon)
    {
        super.registerIcons(icon);
        // This is so hacky it makes me ashamed
        ParticleRegistry.populateIcons(icon);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te != null && te instanceof EmitterTileEntity)
        {
            entityPlayer.openGui(ModParticlePhysics.INSTANCE, 0, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void addStacksDroppedOnBlockBreak(TileEntity tileEntity, ArrayList<ItemStack> itemStacks)
    {
        IInventory decomposer = (IInventory) tileEntity;
        for (int slot = 0; slot < decomposer.getSizeInventory(); slot++)
        {
            ItemStack itemstack = decomposer.getStackInSlot(slot);
            if (itemstack != null)
            {
                itemStacks.add(itemstack);
            }
        }
        return;
    }

}
