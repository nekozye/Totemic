package totemic_commons.pokefenn.totem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import totemic_commons.pokefenn.ModItems;
import totemic_commons.pokefenn.api.ITotemEffect;
import totemic_commons.pokefenn.tileentity.TileTotemBase;
import totemic_commons.pokefenn.util.EntityUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 23/01/14
 * Time: 14:15
 */
public class TotemEffectCactus implements ITotemEffect
{
    public static void effect(TileTotemBase totemBase)
    {
        int SLOT_TWO = TileTotemBase.SLOT_TWO;

        if (totemBase.getStackInSlot(SLOT_TWO).itemID == ModItems.chlorophyllCrystal.itemID)
        {

            if (EntityUtil.getEntitiesInRange(totemBase.worldObj, totemBase.xCoord, totemBase.yCoord, totemBase.zCoord, 10, 10) != null && !(totemBase.getStackInSlot(TileTotemBase.SLOT_TWO).getMaxDamage() - totemBase.getStackInSlot(totemBase.SLOT_TWO).getItemDamage() - totemBase.DECREASE_CACTUS <= 0))
            {

                for (Entity entity : EntityUtil.getEntitiesInRange(totemBase.worldObj, totemBase.xCoord, totemBase.yCoord, totemBase.zCoord, 10, 10))
                {
                    if (!(entity instanceof EntityItem))
                    {
                        entity.attackEntityFrom(DamageSource.generic, 4);

                        totemBase.chlorophyllCrystalHandler(TileTotemBase.DECREASE_CACTUS);

                    }
                }

            }
        }
    }
}