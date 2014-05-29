package particlephysics.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import particlephysics.ParticlePhysicsTab;
import particlephysics.entity.particle.TemplateParticle;

public class PotentialReader extends Item
{

    public PotentialReader(int par1)
    {
        super(par1);
        setMaxStackSize(1);
        setCreativeTab(ParticlePhysicsTab.instance);
        setUnlocalizedName("potentialReader");
    }

    @Override
    public void registerIcons(IconRegister register)
    {
        this.itemIcon = register.registerIcon("minechem:potentialReader");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {

        if (entity instanceof TemplateParticle)
        {
            TemplateParticle particle = (TemplateParticle) entity;
            player.addChatMessage("Potential: " + particle.potential);
            return true;
        }
        return false;
    }

}
